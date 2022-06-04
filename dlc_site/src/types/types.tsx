
export interface Team {
    id: number
    name: string,
    athletes: Array<Athlete | never>
    coach: Coach
}

export interface Athlete {
    id: number,
    name: string,
    email: string,
    programs: [MacroCycle]
}

export interface Coach {
    id: number,
    name: string,
    athletes: Array<Athlete | never>
    email: string,
}

export interface MacroCycle {
    id: number,
    name: string,
    athletes: Array<Athlete | never>,
    team: Team,
    coach: Coach
}

export interface IRegistrationMode {
    type: string
}
