import Keycloak from "keycloak-js"

const keycloak = new Keycloak({
    url: 'http://localhost:8080/',
    realm: 'DLC_REALM',
    clientId: 'dlc_site'
})

//keycloak.init({ onLoad: 'login-required' })

export default keycloak