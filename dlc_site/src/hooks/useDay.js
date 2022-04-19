import { useState, useEffect } from "react"

export const useDay = (dayObj) => {
    const [day, setDay] = useState(dayObj)
console.log(day)
    const addExercise = () => {
        const newExercise = {
            type: '',
            name: '',
            weight: 0,
            sets: 0,
            reps: 0,
            notes: ''
        }
        const dayCopy = { ...day }
        dayCopy.exercises.push(newExercise)
        setDay(dayCopy)
    }

    const updateDay = (updatedDay) => {
        setDay(updatedDay)
    }

    return { day, addExercise, updateDay }
}