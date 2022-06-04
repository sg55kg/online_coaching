import '@testing-library/react'
import { fireEvent, render, screen } from '@testing-library/react'
import AdminNav from '../AdminNav'
import { BrowserRouter as Router } from 'react-router-dom'
import { AdminProvider } from '../../../contexts/AdminContext'

describe('Admin Navbar tests', () => {

    beforeEach(() => {
        render(
            <Router>
                <AdminNav />
            </Router>
        )
    })

    it('Should be collapsed on init', () => {
        const homeLink = screen.queryByText(/home/i)
       
        expect(homeLink).not.toBeInTheDocument()
    }) 

    it('Should have a toggle button', () => {
        const toggleButton = screen.getByRole('button', { hidden: true })
        expect(toggleButton).toBeInTheDocument()
    })

    it('Should expand when toggle button is clicked', () => {
        const toggleButton = screen.getByRole('button', { hidden: true })
        fireEvent.click(toggleButton)

        expect(screen.getByText(/home/i)).toBeInTheDocument()
    })
})

describe('Admin Nav with context', () => {
    beforeEach(() => {
        render(
            <Router>
                <AdminProvider>
                    <AdminNav />
                </AdminProvider>
            </Router>
        )
    })

    it('Should list team names when nav is opened', () => {
        const toggleButton = screen.getByRole('button', { hidden: true })
        fireEvent.click(toggleButton) 

        expect(screen.getByText(/DLC/i)).toBeInTheDocument()
    })
})