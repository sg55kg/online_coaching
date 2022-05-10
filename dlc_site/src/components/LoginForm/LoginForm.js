import { Card, Form, Alert, Spinner } from 'react-bootstrap'
import { useLogin } from './hooks/useLogin'

const LoginForm = () => {
    
    const { 
        email,
        password, 
        error,
        loading,
        changeEmail, 
        changePassword,
        handleLogin
    } = useLogin()

    return (
        <Card>
            <Card.Body>
                {error &&
                    <Alert variant="danger">{error.message}</Alert>
                }
                <Form>
                    <Form.Group>
                        <Form.Control 
                            type="text"
                            placeholder="Email"
                            value={email}
                            onChange={changeEmail}
                        />
                    </Form.Group>
                    <Form.Group>
                        <Form.Control 
                            type="password"
                            placeholder="Password"
                            value={password}
                            onChange={changePassword}
                        />
                    </Form.Group>
                    {!loading &&
                        <button
                            onClick={handleLogin}
                        >Login</button>
                    }
                    {loading &&
                        <button disabled>
                            <Spinner variant="light" animation="grow" /> 
                            Logging in...
                        </button>
                    }
                </Form>
            </Card.Body>
        </Card>
    )
}

export default LoginForm