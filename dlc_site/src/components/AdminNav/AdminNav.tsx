import { Dispatch, SetStateAction } from "react"
import { Drawer, ScrollArea, Navbar, Divider } from "@mantine/core"
import { useContext } from "react"
import { Link } from "react-router-dom"
import { AdminContext, useAdminContext } from "../../contexts/AdminContext"


const AdminNav: React.FC<{viewNav: boolean, setViewNav: Dispatch<SetStateAction<boolean>>}> = ({ viewNav, setViewNav}) => {
    const { teams, coach } = useAdminContext()

    const dummyTeams = [
        { name: 'Team1' },
        { name: 'Team2' },
        { name: 'Team3' },
        { name: 'Team4' },
        { name: 'Team5' }
    ]

    if(!viewNav) return null

    return (
        <Navbar
            title="Title"
            hidden={!viewNav}
            position={{ top: 0, left: 0 }}
            width={{ sm: 500, lg: 400 }}
            style={{ backgroundColor: 'rgb(79, 79, 80)', border: 'none' }}
        >
            <Navbar.Section>
                <h3>
                    Teams
                </h3>
                <div>
                    <ScrollArea style={{ height: 200, color: 'yellow' }}>
                        {dummyTeams.map(team => {
                            return (
                                <div style={{ backgroundColor: 'rgb(51, 51, 51)', padding: '1em' }} key={team.name}>
                                    {team.name}
                                </div>
                            )
                        })}
                    </ScrollArea>
                    <p>+ Add Team</p>
                </div>
            </Navbar.Section>
            <Divider style={{ border: '1px solid black' }} />
                
            
            
            
            
        </Navbar>
    )
}

export default AdminNav