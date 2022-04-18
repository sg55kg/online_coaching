import { useState, useEffect } from 'react'
import { BsPlusCircleDotted } from 'react-icons/bs'
import DaysTable from './DaysTable'

const WriteWeek = () => {
    const [days, setDays] = useState([])

    const athleteData = {
        name: 'AJ Flores',
        snatch: 125,
        cleanAndJerk: 152,
        backSquat: 185,
        frontSquat: 175,
        deadlift: 210
    }

    const getDayOfWeek = () => {
        switch(days.length) {
            case 0:
                return 'Monday'
            case 1:
                return 'Tuesday'
            case 2:
                return 'Wednesday'
            case 3:
                return 'Thursday'
            case 4:
                return 'Friday'
            case 5:
                return 'Saturday'
            case 6:
                return 'Sunday'
            default:
                throw new Error('Too many days')
        }
    }

    const addDay = () => {
        try {
            const newDay = {
                exercises: [],
                dayOfWeek: getDayOfWeek()
            }
            const prevDays = [...days]
            prevDays.push(newDay)
            setDays(prevDays)
        } catch (error) {
            return console.log(error)
        }
    }

    return (
        <div className="write-week-container">
            {days.length > 0 && days.map((day) => {
                return (
                    <DaysTable day={day} />
                )
            })}
            <BsPlusCircleDotted className="add-day-btn" style={{ fontSize: '2em' }} onClick={addDay} />
        </div>
    )
}

export default WriteWeek