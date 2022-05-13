import { useState, useEffect } from 'react'
import { useExercise } from './hooks/useExercise'
import { BiPencil } from 'react-icons/bi'
import { FcCheckmark } from 'react-icons/fc'

interface Exercise {
    type: string,
    name: string,
    weight: number,
    sets: number,
    reps: number,
    notes: string
}

const ExerciseTable: React.FC<{exerciseObj: Exercise}> = ({ exerciseObj }) => {
    const [editMode, setEditMode] = useState<boolean>(false)
    const { exercise, updateExercise } = useExercise(exerciseObj)

    useEffect(() => {

    },[])

    const handleChange = (event: React.FormEvent<HTMLInputElement>, key: string) => {
        const copy = { ...exercise, [key]: event.currentTarget.value }
        updateExercise(copy)
    }

    return(
        <div style={{ display: 'flex', flexDirection: 'row' }}>
            { !editMode && 
            <>
            <BiPencil style={{ color: 'lightblue', width: '5%', fontSize: '1.5em', margin: 'auto' }} onClick={() => setEditMode(true)} />
            <div className="exercise-content-row">   
                <div style={{ width: '20%', fontWeight: 700 }}>{exercise.type !== '' ? exercise.type : '-'}</div>
                <div style={{ width: '15%', fontWeight: 700 }}>{exercise.weight}</div>
                <div style={{ width: '15%', fontWeight: 700 }}>{exercise.sets}</div>
                <div style={{ width: '15%', fontWeight: 700 }}>{exercise.reps}</div>
                <div style={{ width: '35%' }}>{exercise.notes !== '' ? exercise.notes : '-'}</div>
            </div>
            </>
            }
            {editMode &&
            <>
            <FcCheckmark style={{ width: '5%', fontSize: '1.5em', margin: 'auto' }} onClick={() => setEditMode(false)} />
            <div className="exercise-content-row">   
                <input type="text" style={{ width: '20%', fontWeight: 700 }} defaultValue={exercise.type} onChange={(e) => handleChange(e, 'type')} />
                <input type="text" style={{ width: '15%', fontWeight: 700 }} defaultValue={exercise.weight} onChange={(e) => handleChange(e, 'weight')} />
                <input type="text" style={{ width: '15%', fontWeight: 700 }} defaultValue={exercise.sets} onChange={(e) => handleChange(e, 'sets')}/>
                <input type="text" style={{ width: '15%', fontWeight: 700 }} defaultValue={exercise.reps} onChange={(e) => handleChange(e, 'reps')} />
                <input type="text" style={{ width: '35%' }} defaultValue={exercise.notes} onChange={(e) => handleChange(e, 'notes')} />
            </div>
            </>
            }
        </div>
    )
}

export default ExerciseTable