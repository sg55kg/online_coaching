import '@testing-library/react'
import { screen, render } from '@testing-library/react'
import LoginForm from '../LoginForm'

describe('Login Form tests', () => {

    beforeEach(() => {
        render (
            <LoginForm />
        )
    })

    it('Should render with blank input fields', () => {
        const emailField = screen.getByPlaceholderText('Email')
        const passwordField = screen.getByPlaceholderText('Password')

        expect(emailField.value).toBe('')
        expect(passwordField.value).toBe('')
    })

    it('Should disable button on click', () => {

    })

    it('Should disable button if fields are empty', () => {

    })

    it('Should display error message if incorrect information is entered', () => {

    })
})