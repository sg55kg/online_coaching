import { useState } from 'react'
import * as util from '../util/util'
import { saveDay } from '../../../api/days'

export const useDays = () => {
    const [days, setDays] = useState([])
    


    const addDay = () => {
        try {
            const newDay = {
                exercises: [],
                date: util.getDayOfWeek()
            }
            const prevDays = [...days]
            prevDays.push(newDay)
            setDays(prevDays)
        } catch (error) {
            return console.log(error)
        }
    }

    return { days, addDay }
}