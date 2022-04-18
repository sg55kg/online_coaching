import { useState } from 'react'
import { BsNodePlus } from 'react-icons/bs'

import ExerciseTable from './ExerciseTable'

const DaysTable = ({ day }) => {
    // add functionality to click on exercise weight and see lbs/kg

    const [exercises, setExercises] = useState([])

    const addExercise = () => {
        const newExercise = {
            type: '',
            name: '',
            weight: 0,
            sets: 0,
            reps: 0,
            notes: ''
        }
        const prevExercises = [...day.exercises]
        prevExercises.push(newExercise)
        setExercises(prevExercises)
        day.exercises = prevExercises
        //obv will need to add more thought to this to update back/front end
    }
console.log(day.exercises)
    return (
        <div className="write-day-container">
            <div className="write-day-header">
                <h1>{day.dayOfWeek}</h1>
            </div>
            <div style={{ display: 'flex', flexDirection: 'column', height: '5em', justifyContent: 'center' }}>
                <div className="exercise-header">
                    <div>Lift</div>
                    <div>Weight (kg)</div>
                    <div>Sets</div>
                    <div>Reps</div>
                    <div>Notes</div>
                </div>
                {day.exercises.length > 0 && day.exercises.map((exercise) => {
                    return (
                        <ExerciseTable exercise={exercise} />
                    )
                })}
                {day.exercises.length < 1 && 
                    <h4 style={{ margin: '.5em' }}>{`No exercises for ${day.dayOfWeek} yet`}</h4>
                }
                <div style={{ alignSelf: 'flex-start', marginLeft: '5%'}}>
                <BsNodePlus className="add-exercise-btn" onClick={addExercise} />
                </div>
            </div>
            
        </div>
    )
}

export default DaysTable