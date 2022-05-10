import { useState, useEffect } from 'react'
import { BsPlusCircleDotted } from 'react-icons/bs'
import DaysTable from '../DaysTable/DaysTable'
import { useDays } from './hooks/useDays'


const WriteWeek = () => {
    
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
            {days.length > 0 && days.map((day) => {
                return (
                    <DaysTable dayObj={day} />
                )
            })}
            <BsPlusCircleDotted className="add-day-btn" style={{ fontSize: '2em' }} onClick={addDay} />
        </div>
    )
}

export default WriteWeek