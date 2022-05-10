import { navigateToLoginPage, navigateToSignupPage } from './util/util'
import Navbar from 'react-bootstrap/Navbar'

const Header = () => {
    return (   
        <div className="header-container">
            <div className="header-titles">
                <h1 className="site-title-heading">Dollar Lift Club</h1>
                <h5 className="site-location-subheader"><i>Create Week</i></h5>
            </div>
            <div>
                <button 
                    onClick={navigateToSignupPage}
                >Get Started</button>
                <button 
                    onClick={navigateToLoginPage}
                >Login</button>
            </div>
        </div>
    )
}

export default Header