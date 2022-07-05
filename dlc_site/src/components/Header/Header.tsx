import React, { Dispatch, SetStateAction, useState } from 'react'
import { navigateToLoginPage, navigateToSignupPage } from './util/util'
import { Burger, Button, Divider, Menu } from '@mantine/core'
import { useKeycloak } from '@react-keycloak/web'
import AdminNav from '../AdminNav/AdminNav'
import { FiSettings } from 'react-icons/fi'
import { BsCalendar3, BsChat, BsDoorOpen } from 'react-icons/bs'
import { Link } from 'react-router-dom'

const Header: React.FC<{viewNav: boolean, setViewNav: Dispatch<SetStateAction<boolean>>}> = ({ viewNav, setViewNav }) => {



    const { keycloak } = useKeycloak()

    return (   
        <div className="header-container">
            <div style={{ display: 'flex', flexDirection: 'row' }}>
                <Burger onClick={() => setViewNav(!viewNav)} opened={viewNav} />

                <div className="header-titles">
                    <h1 className="site-title-heading">Site Title</h1>
                </div>
            </div>
            
            <div>
                
                {false && //!keycloak.authenticated &&
                    <>
                        <Button 
                            onClick={() => navigateToSignupPage()}
                            variant="gradient"
                            gradient={{ from: 'orange', to: 'red' }}
                        >Get Started</Button>
                        <Button
                            variant="subtle" 
                            onClick={() => keycloak.login()}
                        >Login</Button>
                    </>
                }
                { true && //!!keycloak.authenticated && 
                <>
                    <Menu>
                        <Menu.Label>Options</Menu.Label>
                        <Menu.Item icon={<FiSettings />}>Settings</Menu.Item>
                        <Menu.Item icon={<BsChat />}>Chat</Menu.Item>
                        <Divider />
                        <Menu.Item
                            icon={<BsDoorOpen />}
                            onClick={() => keycloak.logout()}
                        >Sign Out</Menu.Item>
                    </Menu>
                    <div>
                        <Button
                            component={Link}
                            to="calendar"
                            variant="outline"
                        >
                            <BsCalendar3 style={{ fontSize: '1.5em' }} />
                        </Button>
                    </div>
                    </>
                }
                
            </div>
        </div>
    )
}

export default Header