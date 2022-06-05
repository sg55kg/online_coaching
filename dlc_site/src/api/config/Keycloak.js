import Keycloak from "keycloak-js"

const keycloak = new Keycloak({
    url: 'http://localhost:8081',
    realm: 'DLC_REALM',
    clientId: 'dlc_site'
})

export default keycloak