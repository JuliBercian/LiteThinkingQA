describe('template spec', () => {
  it('Locator Get', () => {
    cy.visit('https://the-internet.herokuapp.com/checkboxes')
    cy.get('#checkboxes input:first').click()
  })

  it('Locator Contains', () => {
    cy.visit('https://the-internet.herokuapp.com/dynamic_controls')
    cy.get('button').contains('Remove').click()
  })

})