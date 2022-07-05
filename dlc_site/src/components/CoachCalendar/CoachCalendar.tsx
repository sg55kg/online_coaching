import { Indicator } from '@mantine/core'
import { Calendar } from '@mantine/dates'
import React, { SetStateAction } from 'react'

const CoachCalendar: 
    React.FC<{ selectedDate: Date | null, setSelectedDate: React.Dispatch<SetStateAction<Date | null>>}> = ({ 
        selectedDate, 
        setSelectedDate 
    }) => {

    return (
        <div style={{ width: '100%' }}> 
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
                    day: { 
                        color: 'white', 
                        fontSize: '1.1em' 
                    },
                    cell: { 
                        //padding: '.5em' 
                    },
                    weekend: { color: 'white' },
                    calendarHeaderLevel: { color: 'white' },
                    calendarBase: { width: '100%', maxWidth: '100vw' },
                    month: { margin: '0' } 
                }}
                classNames={{
                    calendarBase: 'calendarbase-custom',
                    month: 'month-custom'
                }} 
                style={{ width: '100%', marginRight: 0, maxWidth: '100%' }} 
            />
        </div>
    )
}

export default CoachCalendar