import axios, { AxiosResponse } from 'axios'

export const getAllCoachAthletes: (coachId: number) => Promise<AxiosResponse> = async (coachId) => {
    const response = await axios.get(`http://localhost:8080/data/coach/athletes/?CoachId=${coachId}`)
    return response
}