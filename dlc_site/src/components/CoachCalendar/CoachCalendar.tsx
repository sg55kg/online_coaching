import { Indicator } from '@mantine/core'
import { Calendar } from '@mantine/dates'
import React, { SetStateAction } from 'react'

const CoachCalendar: 
    React.FC<{ selectedDate: Date | null, setSelectedDate: React.Dispatch<SetStateAction<Date | null>>}> = ({ 
        selectedDate, 
        setSelectedDate 
    }) => {

    return (
        <div>
            <Calendar 
                value={selectedDate}
                onChange={setSelectedDate}
                renderDay={(date) => {
                    const day = date.getDate()
                    return (
                        <Indicator size={6} color="red" offset={8} disabled={day !== 12}>
                            {day}
                        </Indicator>
                    )
                }}
                styles={{
                    day: { color: 'white' },
                    weekend: { color: 'white' },
                }}
            />
        </div>
    )
}

export default CoachCalendar