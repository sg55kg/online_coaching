import React, { createContext, useContext, useState } from "react";
import { Coach, Team } from "../types/types";

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
    coach: {
        id: 1,
        name: 'Sam Dollar',
        athletes: [],
        email: 'sdollar1@gmail.com'
    }
}

export const AdminContext = createContext<IAdminContext>(defaultValue)

export const useAdminContext = () => {
    useContext(AdminContext)
}

export const AdminProvider: React.FC<{children: React.ReactNode}> = ({ children }) => {
    const [teams, setTeams] = useState<Array<Team | never>>(defaultValue.teams)
    const [coach, setCoach] = useState<Coach | null>(defaultValue.coach)

    const value = {
        teams,
        coach
    }

    return (
        <AdminContext.Provider value={value}>
            {children}
        </AdminContext.Provider>
    )
}