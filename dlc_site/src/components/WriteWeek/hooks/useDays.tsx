import { useState } from 'react'
import * as util from '../util/util'
import { saveDay } from '../../../api/days'

interface Day {
    exercises: Array<any>,
    date: Date
}

export const useDays = () => {
    const [days, setDays] = useState<Array<Day>>([])
    

    const addDay = (): void => {
        try {
            const newDay = {
                exercises: [],
                date: util.getDayOfWeek(days.length)
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