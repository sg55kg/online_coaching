import axios from 'axios'

export const getToken: (email: string, password: string) => Promise<object> = async (email, password) => {
    const token = await axios.post('http://localhost:8080/realms/DLC_REALM/protocol/openid-connect/token', {
        data: {
            'client_id': 'dlc_server',
            'username': email,
            'password': password,
            'grant_type': 'password'
        },
        headers: {
            'Content-type': 'application/x-www-form-urlencoded',
            "Access-Control-Allow-Origin": "*",
        },
        withCredentials: true
    })

    return token.data
}