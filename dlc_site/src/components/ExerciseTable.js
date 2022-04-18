import { useState } from 'react'
import { BiPencil } from 'react-icons/bi'

const ExerciseTable = ({ exercise }) => {
    const [editMode, setEditMode] = useState(false)

    return(
        <div style={{ display: 'flex', flexDirection: 'row' }}>
            <BiPencil style={{ color: 'lightblue', width: '5%', fontSize: '1.5em' }} onClick={() => setEditMode(true)} />
            <div style={{ width: '95%', display: 'flex', flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center' }}>   
                <div style={{ width: '15%', fontWeight: 700 }}>{exercise.type !== '' ? exercise.type : '-'}</div>
                <div style={{ width: '10%', fontWeight: 700 }}>{exercise.weight}</div>
                <div style={{ width: '10%', fontWeight: 700 }}>{exercise.sets}</div>
                <div style={{ width: '10%', fontWeight: 700 }}>{exercise.reps}</div>
                <div style={{ width: '20%' }}>{exercise.notes !== '' ? exercise.notes : '-'}</div>
            </div>
        </div>
    )
}

export default ExerciseTable