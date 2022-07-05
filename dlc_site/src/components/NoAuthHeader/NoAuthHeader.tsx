import { Button } from '@mantine/core'
import { useKeycloak } from '@react-keycloak/web'

const NoAuthHeader = () => {
    const { keycloak } = useKeycloak()
    return (
        <div className="header-container">
            <>
                <Button 
                    // onClick={() => navigateToSignupPage()}
                    variant="gradient"
                    gradient={{ from: 'orange', to: 'red' }}
                >Get Started</Button>
                <Button
                    variant="subtle" 
                    onClick={() => keycloak.login()}
                >Login</Button>
            </>
        </div>
    )
}

export default NoAuthHeader