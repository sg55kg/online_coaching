import { useState, useEffect } from "react"

interface Exercise {
    type: string,
    name: string,
    weight: number,
    sets: number,
    reps: number,
    notes: string
}

export const useExercise = (exerciseObj: Exercise) => {
    const [exercise, setExercise] = useState(exerciseObj)
    
    const updateExercise = (updatedExercise: Exercise) => {
        setExercise(updatedExercise)
    }

    return { exercise, updateExercise }
}