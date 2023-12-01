describe('Actions in the internet app', ()=> {

    it('check', () => {
        cy.visit('https://the-internet.herokuapp.com/checkboxes')
        cy.get('#checkboxes input:first').check()
    })

    it('uncheck', () => {
        cy.visit('https://the-internet.herokuapp.com/checkboxes')
        cy.get('#checkboxes input:last').uncheck()
    })

    it('Type', () => {
        cy.visit('https://the-internet.herokuapp.com/login')
        cy.get('#username').type('DarioNarvaez')
        cy.get('#password').type('Password1234')
        cy.get('button').click()
    })

    it('Select', () => {
        cy.visit('https://the-internet.herokuapp.com/dropdown')
        cy.get('#dropdown').select('Option 1')
    })

    it('Clear', () => {
        cy.visit('https://the-internet.herokuapp.com/login')
        cy.get('#username').type('DarioNarvaez')
        cy.get('#password').type('Password1234')
        cy.get('#username').clear()
        cy.get('#password').clear()
    })

})