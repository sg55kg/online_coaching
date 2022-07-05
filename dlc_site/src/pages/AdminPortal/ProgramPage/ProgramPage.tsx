import { useState } from 'react'
import { Card, Divider, Accordion } from '@mantine/core'
import { isMobile } from 'react-device-detect'
import CoachCalendar from '../../../components/CoachCalendar/CoachCalendar'
import WriteWeek from '../../../components/WriteWeek/WriteWeek'
import NewProgramModal from '../../../components/NewProgramModal/NewProgramModal'


const ProgramPage: React.FC = () => {
    const [selectedDate, setSelectedDate] = useState<Date | null>(null)
    const [viewProgramModal, setViewProgramModal] = useState<boolean>(false)

    const fakeAthleteData = [
        {
            name: 'AJ Flores',
            age: 23,
            programs: []
        },
        {
            name: 'Chris Ortiz',
            age: 27,
            programs: []
        },
        {
            name: 'Michael Degrassi',
            age: 26,
            programs: []
        }
    ]

    if(isMobile) {
        return (
            <div
                style={{ width: '100%' }}
            >
                <Accordion
                    style={{ width: '100%' }}
                    styles={{
                        label: {
                            color: 'white'
                        },
                        control: {
                            color: 'white'
                        },
                        content: {
                            padding: '1em'
                        },
                        contentInner: {
                            padding: 0
                        }
                    }}
                >
                    <Accordion.Item style={{ padding: 0 }} label="View Calendar">
                        <CoachCalendar 
                            selectedDate={selectedDate}
                            setSelectedDate={setSelectedDate}
                        />
                        {selectedDate &&
                            <div style={{ color: 'white', textAlign: 'left' }}>
                                <div style={{ paddingTop: '.5em', backgroundColor: '#1f232f' }}>
                                    {fakeAthleteData.map((athlete, index) => {
                                        return (
                                            <div 
                                                key={index}
                                                style={{ paddingBottom: '.75em', display: 'flex' }}
                                            >
                                                <p>{athlete.name}</p>
                                                <button
                                                    onClick={() => setViewProgramModal(true)}
                                                >
                                                    Program btn
                                                </button>
                                            </div>
                                        )
                                    })}
                                </div>
                            </div>
                        }
                    </Accordion.Item>
                    <Accordion.Item style={{ padding: 0 }} label="Activity">

                    </Accordion.Item>
                </Accordion>
                {viewProgramModal &&
                    <NewProgramModal 
                        viewProgramModal={viewProgramModal} 
                        setViewProgramModal={setViewProgramModal} 
                        selectedDate={selectedDate}
                    />
                }
            </div>
        )
    }

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