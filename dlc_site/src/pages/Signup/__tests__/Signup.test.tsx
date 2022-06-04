import '@testing-library/react'
import { fireEvent, render, screen } from '@testing-library/react'
import Signup from '../Signup'
import { BrowserRouter as Router } from 'react-router-dom'

describe('Signup page tests', () => {

    beforeEach(() => {
        render(
            <Router>
                <Signup />
            </Router>
        )
    })

    it('should show options for athlete and coach registration', () => {
        const coachRegistrationBtn = screen.getByText('Register As Athlete')
        const athleteRegistrationBtn = screen.getByText('Register As Coach')

        expect(coachRegistrationBtn).toBeInTheDocument()
        expect(athleteRegistrationBtn).toBeInTheDocument()
    })

    it('should show coach registration form on coach btn click', () => {
        const coachRegistrationBtn = screen.getByText('Register As Coach')

        fireEvent.click(coachRegistrationBtn)

        expect(screen.getByText(/Coach Registration/i)).toBeInTheDocument()
        expect(screen.queryByText(/Athlete Registration/i)).not.toBeInTheDocument()
    })
 
    it('should show athlete registration form on athlete btn click', () => {
        const athleteRegistrationBtn = screen.getByText('Register As Athlete')

        fireEvent.click(athleteRegistrationBtn)

        expect(screen.queryByText(/Coach Registration/i)).not.toBeInTheDocument()
        expect(screen.getByText(/Athlete Registration/i)).toBeInTheDocument()
    })

    it('should give option to login instead', () => {
        const loginBtn = screen.getByText(/login/i)
        expect(loginBtn).toBeInTheDocument()
    })
})