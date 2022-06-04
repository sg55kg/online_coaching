import { useState } from 'react'
import { Card, Button } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import AthleteSignUpForm from '../../components/SignupForm/AthleteSignUpForm/AthleteSignUpForm'
import CoachSignUpForm from '../../components/SignupForm/CoachSignUpForm/CoachSignUpForm'
import { IRegistrationMode } from '../../types/types'

const Signup: React.FC = () => {
    const [registrationMode, setRegistrationMode] = useState<IRegistrationMode>({ type: 'none' })
    

    return (
        <div>
            {registrationMode.type === 'none' &&
                <Card>
                    <Card.Title>
                        Sign Up
                    </Card.Title>
                    <Card.Body>
                        <Button onClick={() => setRegistrationMode({ type: 'coach' })}>
                            Register As Coach
                        </Button>
                        <Button onClick={() => setRegistrationMode({ type: 'athlete' })}>
                            Register As Athlete
                        </Button>
                        <div>
                            <Card.Text>
                                Already have an account?
                                <Link to="/login"> Login</Link>
                            </Card.Text>
                        </div>
                    </Card.Body>
                </Card>
            }
            {registrationMode.type === 'coach' &&
                <CoachSignUpForm />
            }
            {registrationMode.type === 'athlete' &&
                <AthleteSignUpForm />
            }
        </div>
    )
}

export default Signup