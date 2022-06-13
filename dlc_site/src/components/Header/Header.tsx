import React, { Dispatch, SetStateAction, useState } from 'react'
import { navigateToLoginPage, navigateToSignupPage } from './util/util'
import { Burger, Button } from '@mantine/core'
import { useKeycloak } from '@react-keycloak/web'
import AdminNav from '../AdminNav/AdminNav'

const Header: React.FC<{viewNav: boolean, setViewNav: Dispatch<SetStateAction<boolean>>}> = ({ viewNav, setViewNav }) => {


    const { keycloak } = useKeycloak()

    return (   
        <div className="header-container">
            <div style={{ display: 'flex', flexDirection: 'row' }}>
                <Burger onClick={() => setViewNav(!viewNav)} opened={viewNav} />

                <div className="header-titles">
                    <h1 className="site-title-heading">Site Title</h1>
                    <h5 className="site-location-subheader"><i>Specific Page Subtitle</i></h5>
                </div>
            </div>
            
            <div>
                
                {!keycloak.authenticated &&
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