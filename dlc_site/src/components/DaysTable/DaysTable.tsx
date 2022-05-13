//import { useState } from 'react'
import { BsNodePlus, BsGear } from 'react-icons/bs'
import { useDay } from './hooks/useDay'

import ExerciseTable from '../ExerciseTable/ExerciseTable'

interface Exercise {
    type: string,
    name: string,
    weight: number,
    sets: number,
    reps: number,
    notes: string
}

interface Day {
    exercises: Array<Exercise>,
    date: Date
}

const DaysTable: React.FC<{dayObj: Day}> = ({ dayObj }) => {
    // add functionality to click on exercise weight and see lbs/kg

    const { day, updateDay, addExercise } = useDay(dayObj)

    return (
        <div className="write-day-container">
            <div className="write-day-header">
                <h1>{day.date.toLocaleDateString()}</h1>
                <BsGear className="day-header-gear" style={{ fontSize: '1.5em' }} />
            </div>
            <div style={{ display: 'flex', flexDirection: 'column', minHeight: '5em', justifyContent: 'center' }}>
                <div className="exercise-header">
                    <div style={{ textAlign: 'center', width: '20%' }}>Lift</div>
                    <div style={{ textAlign: 'center', width: '15%' }}>Weight (kg)</div>
                    <div style={{ textAlign: 'center', width: '15%' }}>Sets</div>
                    <div style={{ textAlign: 'center', width: '15%' }}>Reps</div>
                    <div style={{ textAlign: 'center', width: '35%' }}>Notes</div>
                </div>
                {day.exercises.length > 0 && day.exercises.map((exercise) => {
                    return (
                        <ExerciseTable exerciseObj={exercise} />
                    )
                })}
                {day.exercises.length < 1 && 
                    <h4 style={{ margin: '.5em' }}>{`No exercises for ${day.date.toLocaleDateString()} yet`}</h4>
                }
                <div style={{ alignSelf: 'flex-start', marginLeft: '5%'}}>
                <BsNodePlus className="add-exercise-btn" onClick={addExercise} />
                </div>
            </div>
            
        </div>
    )
}

export default DaysTable