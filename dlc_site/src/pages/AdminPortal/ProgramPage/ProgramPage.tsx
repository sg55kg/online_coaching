import { useState } from 'react'
import { Card, Divider } from '@mantine/core'
import CoachCalendar from '../../../components/CoachCalendar/CoachCalendar'
import WriteWeek from '../../../components/WriteWeek/WriteWeek'

const ProgramPage: React.FC = () => {
    const [selectedDate, setSelectedDate] = useState<Date | null>(null)

    console.log(selectedDate)
    return (
        <div style={{ display: 'flex' }}>
            <div style={{ display: 'flex', flexDirection: 'column' }}>
                <Card style={{ borderRadius: '0', backgroundColor: 'rgb(79, 79, 80)' }}>
                    <CoachCalendar 
                        selectedDate={selectedDate}
                        setSelectedDate={setSelectedDate}
                    />
                </Card>
                <Divider />
                <Card style={{ borderRadius: '0', backgroundColor: 'rgb(79, 79, 80)' }}>
                    <Card.Section>
                        <p>{selectedDate ? selectedDate.toLocaleDateString() : 'Select a Date'}</p>
                    </Card.Section>
                    <Divider />
                    <Card.Section>
                        <h3>Team 1</h3>
                        <h6>Athlete</h6>
                        <h6>Athlete</h6>
                    </Card.Section>
                </Card>
            </div>
            <div>
                <WriteWeek />
            </div>
        </div>
    )
}

export default ProgramPage