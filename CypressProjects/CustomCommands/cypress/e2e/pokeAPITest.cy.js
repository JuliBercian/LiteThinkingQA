describe('PokeAPI', () => {
  it('Get Pokemos', () => {

    const headers = {
      authenticator: 'Bearer 1234124123412341241234'
    }
    const queryParams = {
      limit: 10,
      offset: 0
    }
    cy.request(
      {
        method: "GET",
        url: 'https://pokeapi.co/api/v2/pokemon',
        qs: queryParams,
        headers: headers
      })
  })
})