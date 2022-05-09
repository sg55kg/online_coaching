import Navbar from 'react-bootstrap/Navbar'

const Header = () => {
    return (

        
        <div className="header-container">
            <Navbar.Toggle />
            <h1 className="site-title-heading">Dollar Lift Club</h1>
            <h5 className="site-location-subheader"><i>Create Week</i></h5>
        </div>
    )
}

export default Header