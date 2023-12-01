describe('template spec', () => {
  it('Children', () => {
    cy.visit('https://the-internet.herokuapp.com/checkboxes')
    // cy.get('#checkboxes input:first').check()
    cy.get('#checkboxes').children().first().click()
  })

  it('Next', () => {
    cy.visit('https://the-internet.herokuapp.com/abtest')
    // cy.get('#content .example h3').next()
    cy.get('#content .example h3').invoke('text').then((text) => {
      cy.log('Element text', text);
    });
    cy.get('#content .example h3').next().invoke('text').then((text) => {
      cy.log('Element text', text);
    });
  })

  it('Siblinds', () => {
    cy.visit('https://the-internet.herokuapp.com/disappearing_elements')
    cy.get('ul li').first().siblings().first().click()
  })

  it('Parents', () => {
    cy.visit('https://the-internet.herokuapp.com/disappearing_elements')
    cy.get('ul').parent().invoke('text').then((text) => {
      cy.log('The parent text is:', text);
    });
  })

})