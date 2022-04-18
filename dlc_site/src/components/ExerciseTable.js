import { useState, useEffect } from 'react'
import { BiPencil } from 'react-icons/bi'
import { FcCheckmark } from 'react-icons/fc'

const ExerciseTable = ({ exercise }) => {
    const [editMode, setEditMode] = useState(false)
    const [exerciseState, setExerciseState] = useState({})

    useEffect(() => {
        const exercisePropsCopy = { ...exercise }
        setExerciseState(exercisePropsCopy)
    },[])

    useEffect(() => {
        
    },[])

    const handleChange = (event, key) => {
        const copy = { ...exerciseState, key: event.target.value }
        setExerciseState(copy)
    }

    return(
        <div style={{ display: 'flex', flexDirection: 'row' }}>
            { !editMode && 
            <>
            <BiPencil style={{ color: 'lightblue', width: '5%', fontSize: '1.5em' }} onClick={() => setEditMode(true)} />
            <div style={{ width: '95%', display: 'flex', flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center' }}>   
                <div style={{ width: '15%', fontWeight: 700 }}>{exercise.type !== '' ? exercise.type : '-'}</div>
                <div style={{ width: '10%', fontWeight: 700 }}>{exercise.weight}</div>
                <div style={{ width: '10%', fontWeight: 700 }}>{exercise.sets}</div>
                <div style={{ width: '10%', fontWeight: 700 }}>{exercise.reps}</div>
                <div style={{ width: '20%' }}>{exercise.notes !== '' ? exercise.notes : '-'}</div>
            </div>
            </>
            }
            {editMode &&
            <>
            <FcCheckmark style={{ width: '5%', fontSize: '1.5em' }} onClick={() => setEditMode(false)} />
            <div style={{ width: '95%', display: 'flex', flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center' }}>   
                <input type="text" style={{ width: '15%', fontWeight: 700 }} defaultValue={exerciseState.type} onChange={(e) => handleChange(e, 'type')} />
                <input type="text" style={{ width: '10%', fontWeight: 700 }} defaultValue={exerciseState.weight} onChange={(e) => handleChange(e, 'weight')} />
                <input type="text" style={{ width: '10%', fontWeight: 700 }} defaultValue={exerciseState.sets} onChange={(e) => handleChange(e, 'sets')}/>
                <input type="text" style={{ width: '10%', fontWeight: 700 }} defaultValue={exerciseState.reps} onChange={(e) => handleChange(e, 'reps')} />
                <input type="text" style={{ width: '20%' }} defaultValue={exerciseState.notes} onChange={(e) => handleChange(e, 'notes')} />
            </div>
            </>
            }
        </div>
    )
}

export default ExerciseTable