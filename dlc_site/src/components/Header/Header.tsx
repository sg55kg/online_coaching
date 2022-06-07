import { navigateToLoginPage, navigateToSignupPage } from './util/util'
import Navbar from 'react-bootstrap/Navbar'
import { useKeycloak } from '@react-keycloak/web'

const Header = () => {

    const { keycloak } = useKeycloak()

    return (   
        <div className="header-container">
            <div className="header-titles">
                <h1 className="site-title-heading">Dollar Lift Club</h1>
                <h5 className="site-location-subheader"><i>Create Week</i></h5>
            </div>
            <div>
                <button 
                    onClick={() => navigateToSignupPage()}
                >Get Started</button>
                {!keycloak.authenticated &&
                    <button 
                        onClick={() => keycloak.login()}
                    >Login</button>
                }
                {!!keycloak.authenticated && 
                    <button
                        onClick={() => keycloak.logout()}
                    >Sign Out</button>
                }
            </div>
        </div>
    )
}

export default Header