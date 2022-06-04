import { useContext } from "react"
import { Card, Navbar } from "react-bootstrap"
import { Link } from "react-router-dom"
import { AdminContext, useAdminContext } from "../../contexts/AdminContext"


const AdminNav: React.FC = () => {
    const { teams, coach } = useAdminContext()

    return (
        <Navbar>
            <Navbar.Toggle>

            </Navbar.Toggle>
            <Navbar.Offcanvas>
                <Card.Title>
                    <Link to="/admin">
                        Home
                    </Link>
                </Card.Title>
 
                <Card.Subtitle>
                    Teams
                </Card.Subtitle>

                {teams && teams.length > 0 && 
                    teams.map(team => {
                        return <h1>{team.name}</h1>
                    })
                }
                <hr></hr>

                <Card.Subtitle>
                    Athletes
                </Card.Subtitle>

                <hr></hr>

                <Card.Subtitle>
                    Settings
                </Card.Subtitle>

            </Navbar.Offcanvas>
        </Navbar>
    )
}

export default AdminNav