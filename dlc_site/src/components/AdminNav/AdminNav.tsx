import { Dispatch, SetStateAction } from "react"
import { Drawer, ScrollArea, Navbar } from "@mantine/core"
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
            width={{ base: 600 }}
        >
            <div>
                
                <div>
                    <h3>
                        Teams
                    </h3>
                    <ScrollArea style={{ height: 200 }}>
                        {dummyTeams.map(team => {
                            return (
                                <div style={{ backgroundColor: 'black', padding: '1em' }} key={team.name}>
                                    {team.name}
                                </div>
                            )
                        })}
                    </ScrollArea>
                    <p>+ Add Team</p>
                </div>
            </div>
            
            
        </Navbar>
    )
}

export default AdminNav