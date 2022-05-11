import { useState, useEffect } from "react"

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

export const useDay = (dayObj: Day) => {
    const [day, setDay] = useState<Day>(dayObj)

    const addExercise = (): void => {
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

    const updateDay = (updatedDay: Day) => {
        setDay(updatedDay)
    }

    return { day, addExercise, updateDay }
}