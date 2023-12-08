describe('DEMOQA', () => {

  it('Diligenciar Form', () => {

    cy.on('uncaught:exception', (err, runnable) => {
      console.error('Excepción no capturada:', err.message);
      return false;
    });
    
    cy.visit('https://demoqa.com/automation-practice-form/')


    cy.get('input[id="firstName"]').type('Julissa');
    cy.logText();
    cy.get('input[id="firstName"]').should('have.value', 'Julissa');

    cy.get('input[id="lastName"]').type('Bercian');
    cy.logText();
    cy.get('input[id="lastName"]').should('have.value', 'Bercian');


    cy.get('input[id="userEmail"]').type('bercianmilena@gmail.com');
    cy.logText();
    cy.get('input[id="userEmail"]').should('have.value', 'bercianmilena@gmail.com').then(($input) => {
      const value = $input.val();
      expect(value).to.include('@');
    });

    cy.get('label[for="gender-radio-2"]').click();
    cy.logText();
    cy.get('input[id="gender-radio-2"]').should('be.checked');

    cy.get('input[id="userNumber"]').type('7777777777')
    cy.logText();
    cy.get('input[id="userNumber"]').invoke('val').should('have.length', 10);
    cy.get('input[id="userNumber"]').invoke('val').should('match', /^\d+$/);  
    
    cy.get('#dateOfBirthInput').click();
    cy.get('.react-datepicker__year-select').select('1997');
    cy.get('.react-datepicker__month-select').select('9');
    cy.get('.react-datepicker__day--021').click();
    cy.logText();
    cy.get('#dateOfBirthInput').invoke('val').then((date) => {
      expect(date).to.match(/^\d{2} \w{3} \d{4}$/);
    });


    cy.get('input[id="subjectsInput"]').type('computer');
    cy.get('.subjects-auto-complete__menu-list').contains('Computer Science').click();
    cy.logText();
    cy.contains('.css-12jo7m5.subjects-auto-complete__multi-value__label', 'Computer Science').should('exist');


    cy.get('label[for="hobbies-checkbox-1"]').click();
    cy.get('label[for="hobbies-checkbox-2"]').click();
    cy.get('label[for="hobbies-checkbox-3"]').click();
    cy.logText();
    cy.get('#hobbies-checkbox-1').should('be.checked');
    cy.get('#hobbies-checkbox-2').should('be.checked');
    cy.get('#hobbies-checkbox-3').should('be.checked');

    cy.get('#uploadPicture').selectFile('sm2.png');

    cy.get('#currentAddress').type('San Salvador, El Salvador, Centro América');
    cy.get('#currentAddress').should('have.value', 'San Salvador, El Salvador, Centro América');

    cy.get('#react-select-3-input').click({ force: true });
    cy.contains('.css-yt9ioa-option', 'Haryana').click({ force: true });
    cy.logText();
    cy.get('.css-1uccc91-singleValue').first().should('have.text', 'Haryana');
    
    cy.get('#react-select-4-input').click({ force: true });
    cy.get('.css-1n7v3ny-option').click({ force: true });
    cy.logText();
    cy.get('.css-1uccc91-singleValue').last().should('have.text', 'Karnal');

    cy.logText();
    cy.get('#submit').should('be.visible').click({ force: true })
    
    cy.logText();
    cy.get('.modal-content').should('be.visible');
  });

});
