import { useState, useEffect } from "react"

export const useExercise = (exerciseObj) => {
    const [exercise, setExercise] = useState(exerciseObj)
    
    const updateExercise = (updatedExercise) => {
        setExercise(updatedExercise)
    }

    return { exercise, updateExercise }
}