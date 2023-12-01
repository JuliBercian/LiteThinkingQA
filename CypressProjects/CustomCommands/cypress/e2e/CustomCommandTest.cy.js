describe('template spec', () => {
  it('passes', () => {
    cy.visit('https://example.cypress.io')
    cy.logTextElement('h1')
    cy.logTextElement('#utilities')
  })
})