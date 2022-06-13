import { Card, Divider } from '@mantine/core'
import CoachCalendar from '../../../components/CoachCalendar/CoachCalendar'
import WriteWeek from '../../../components/WriteWeek/WriteWeek'

const ProgramPage: React.FC = () => {
    return (
        <div style={{ display: 'flex' }}>
            <div style={{ display: 'flex', flexDirection: 'column' }}>
                <Card style={{ borderRadius: '0', backgroundColor: 'rgb(79, 79, 80)' }}>
                    <CoachCalendar />
                </Card>
                <Divider />
                <Card style={{ borderRadius: '0', backgroundColor: 'rgb(79, 79, 80)' }}>
                    <Card.Section>
                        Athletes
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