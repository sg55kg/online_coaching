import { useState } from 'react'

const Login: React.FC = () => {
    const [email, setEmail] = useState<string>('')
    const [password, setPassword] = useState<string>('')
    const [loading, setLoading] = useState<boolean>(false)
    const [error, setError] = useState<Error | null>(null)
    
    return (
        <div>
            Login
        </div>
    )
}

export default Login