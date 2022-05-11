import { useState, useEffect } from 'react'
import { BsPlusCircleDotted } from 'react-icons/bs'
import DaysTable from '../DaysTable/DaysTable'
import { useDays } from './hooks/useDays'

interface Day {
    exercises: Array<any>,
    date: Date
}

const WriteWeek: React.FC = () => {
    
    const { days, addDay } = useDays()

    const athleteData = {
        name: 'AJ Flores',
        snatch: 125,
        cleanAndJerk: 152,
        backSquat: 185,
        frontSquat: 175,
        deadlift: 210
    }


    return (
        <div className="write-week-container">
            {days.length > 0 && days.map((dayObj) => {
                return (
                    <DaysTable dayObj={dayObj} />
                )
            })}
            <BsPlusCircleDotted className="add-day-btn" style={{ fontSize: '2em' }} onClick={addDay} />
        </div>
    )
}

export default WriteWeek