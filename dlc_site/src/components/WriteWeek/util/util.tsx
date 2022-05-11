export const getDayOfWeek = (daysArrayLength: number) => {
    const CURRENT_YEAR = new Date().getFullYear()
    const CURRENT_MONTH = new Date().getMonth()

    switch(daysArrayLength) {
        case 0:
            return new Date(CURRENT_YEAR, CURRENT_MONTH, )
        case 1:
            return new Date(CURRENT_YEAR, CURRENT_MONTH, )
        case 2:
            return new Date(CURRENT_YEAR, CURRENT_MONTH, )
        case 3:
            return new Date(CURRENT_YEAR, CURRENT_MONTH, )
        case 4:
            return new Date(CURRENT_YEAR, CURRENT_MONTH, )
        case 5:
            return new Date(CURRENT_YEAR, CURRENT_MONTH, )
        case 6:
            return new Date(CURRENT_YEAR, CURRENT_MONTH, )
        default:
            throw new Error('Too many days')
    }
}

