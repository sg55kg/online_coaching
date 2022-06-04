import { Card, Form } from "react-bootstrap"
import { useFormik } from 'formik'
import * as Yup from 'yup'

const CoachSignUpForm: React.FC = () => {

    const handleSignUp: () => Promise<void> = async () => {

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
            password: Yup.string(),
            passwordConfirm: Yup.string()
        }),
        onSubmit: () => handleSignUp()
    })

    return (
        <Card>
            <Card.Header>
                <Card.Title>
                    Coach Registration
                </Card.Title>
            </Card.Header>
            <Form>

            </Form>
        </Card>
    )
}

export default CoachSignUpForm