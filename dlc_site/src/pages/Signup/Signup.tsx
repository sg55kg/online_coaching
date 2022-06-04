import { useState } from 'react'
import { Card, Form } from 'react-bootstrap'
import { useFormik } from 'formik'
import * as Yup from 'yup'

const Signup: React.FC = () => {
    const [displayName, setDisplayName] = useState<string>('')
    const [email, setEmail] = useState<string>('')
    const [password, setPassword] = useState<string>('')
    const [confirmPassword, setConfirmPassword] = useState<string>('')

    const handleSignUp: () => Promise<any> = async () => {

    }

    const formik = useFormik({
        initialValues: {
            firstName: '',
            lastName: '',
            email: '',
            password: '',
            passwordConfirm: ''
        },
        validationSchema: Yup.object({
            firstName: Yup.string(),
            lastName: Yup.string(),
            email: Yup.string().email(),
            password: Yup.string()
           // passwordConfirm: Yup.string().matches(password)
        }),
        onSubmit: () => handleSignUp()
    })

    

    return (
        <div>
            <Card>
                <Card.Title>Register</Card.Title>
                <Card.Body>
                    <Form>
                        <Form.Group>
                            <Form.Control type="text" placeholder="First Name" />
                        </Form.Group>
                        <Form.Group>
                            <Form.Control type="text" placeholder="Last Name" />
                        </Form.Group>
                        <Form.Group>
                            <Form.Control type="email" placeholder="Email Address" />
                        </Form.Group>
                        <Form.Group>
                            <Form.Control type="password" placeholder="Enter a password" />
                        </Form.Group>
                        <Form.Group>
                            <Form.Control type="password" placeholder="Confirm password" />
                        </Form.Group>
                    </Form>
                </Card.Body>
            </Card>
        </div>
    )
}

export default Signup