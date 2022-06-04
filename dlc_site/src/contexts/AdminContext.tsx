import React, { createContext, useContext, useEffect, useState } from "react";
import { getAllCoachAthletes } from "../api/auth/coach";
import { Athlete, Coach, Team } from "../types/types";
import { useAuth } from "./AuthContext";

interface IAdminContext {
    teams: Array<Team | never>,
    coach?: Coach | null,
    children?: React.ReactNode
}

const defaultValue = {
    teams: [{
        id: 123,
        name: 'DLC',
        athletes: [],
        coach: {
            id: 1,
            name: 'Sam Dollar',
            athletes: [],
            email: 'sdollar1@gmail.com',
        }
    }],
}

export const AdminContext = createContext<IAdminContext>(defaultValue)

export const useAdminContext = () => {
    return useContext(AdminContext)
}

export const AdminProvider: React.FC<{children: React.ReactNode}> = ({ children }) => {
    const [teams, setTeams] = useState<Array<Team | never>>([])
    const [athletes, setAthletes] = useState<Array<Athlete | never>>([])
    const { currentUser } = useAuth()

    const callGetAllAthletes: (coachId: number) => Promise<void> = async (coachId) => {
        try {
            const res = await getAllCoachAthletes(coachId)
            setAthletes(res.data)
        } catch (error) {
            console.log(error)
        }
    }

    useEffect(() => {
        if(currentUser && currentUser.id && athletes.length < 1) {
            callGetAllAthletes(currentUser.id)
        }
    },[currentUser])

    const value = {
        teams,
        athletes
    }

    return (
        <AdminContext.Provider value={value}>
            {children}
        </AdminContext.Provider>
    )
}