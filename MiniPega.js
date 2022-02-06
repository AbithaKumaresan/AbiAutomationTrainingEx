describe('My Suite', function () {
    before (function (){
        cy.fixture('example').then(function(test_data)
        {
            this.credentials = test_data
        })
        })
    it('Test Case 1', function () {
    //Lanuch the URL
    cy.visit(this.credentials.URL)
    //Login to site
    cy.get('input[id=txtUserID]').type(this.credentials.user)
    cy.get('input[id=txtPassword]').type(this.credentials.password)
    cy.get('#sub>span').click()
    //Click on Create 
    cy.get('a.menu-item-anchor.menu-item-expand>span:nth-of-type(2)>span').click()
    //Click on Individual Lead 
    cy.get('ul.menu.menu-format-create-case-menu>li:nth-of-type(7)>a>span').click()
    //Provide the Individual Details
    cy.get('input[title="Lead first name"]').type(this.credentials.FirstName)
    cy.get('input[title="Lead last name"]').type(this.credentials.LastName)
    //Get Pop up Title
    cy.get('h2.header-title').contains('Lead').then(function(text1)
    {
        cy.log(text1.text())
    })
    //Click on Submit
    cy.get('button[title="Complete this assignment"]').click()
    })
    })