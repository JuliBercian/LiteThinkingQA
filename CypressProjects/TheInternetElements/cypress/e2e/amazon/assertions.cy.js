describe('template spec', () => {

  beforeEach( () => {
    cy.visit('https://www.amazon.com')
  })

  it('have.attr', () => {
    cy.get('#twotabsearchtextbox').should('have.attr', 'placeholder', 'Search Amazon')
  })

  it('have.class', () => {
    cy.get('#nav-logo-sprites').should('have.class', 'nav-logo-link')
  })

  it('have.class & have.attr', () => {
    cy.get('#nav-logo-sprites')
    .should('have.class', 'nav-logo-link')
    .should('have.attr', 'aria-label', 'Amazon')
  })


})