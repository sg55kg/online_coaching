import { Modal, Button } from '@mantine/core'
import React, { SetStateAction, useState } from 'react'
import { createProgram } from '../../api/programs/programs'
import { useAuth } from '../../contexts/AuthContext'
import keycloak from '../../api/config/Keycloak'

const NewProgramModal: React.FC<{ 
    viewProgramModal: boolean, 
    setViewProgramModal: React.Dispatch<SetStateAction<boolean>>,
    selectedDate: Date | null
}> = ({ 
    viewProgramModal, 
    setViewProgramModal,
    selectedDate
}) => {
    const { currentUser } = useAuth()
    const [writeDayView, setWriteDayView] = useState<boolean>(false)
    const [newCycle, setNewCycle] = useState({
        coach: currentUser.id,
        athlete: 0,
        startDate: selectedDate,
        microCycles: [],
        totalReps: 0,
        isComplete: false,
        team: 0
    })

    const formStyles = {
        formGroup: {
            'display': 'flex',
            'flex-direction': 'column',
            'padding': '1em'
        }
    }

    const handleCreateMacroCycle = async () => {
        await createProgram(keycloak.idToken!, newCycle)
        console.log('success')
        setWriteDayView(true)
    }

    return (
        <Modal 
            opened={viewProgramModal} 
            onClose={() => setViewProgramModal(false)} 
            size="xl"
            title={selectedDate?.toLocaleDateString()}
        >
            {!writeDayView &&
                <div>
                    <div style={formStyles.formGroup}>
                        <label>
                            Program Name:
                        </label>
                        <input title="program name" type="text" />
                    </div>
                    <div style={formStyles.formGroup}>
                        <label>
                            Start Day
                        </label>
                        <input defaultValue={selectedDate!.toLocaleDateString()} title="start date" type="date" />
                    </div>
                    <div style={formStyles.formGroup}>
                        <label>
                            End Day
                        </label>
                        <input title="end date" type="date" />
                    </div>
                    <div>
                        <Button
                            onClick={handleCreateMacroCycle}
                        >
                            Create
                        </Button>
                    </div>
                </div>
            }
            {writeDayView &&
                <div style={{ width: '90vw' }}>
                    <div style={{ display: 'flex', width: '90vw', padding: '.5em' }}>
                        <input 
                            placeholder="Exercise Name" 
                            type="text" 
                            style={{ width: '25%', padding: '.5em', height: 'fit-content' }}
                        />
                        <input 
                            placeholder="Wgt" 
                            type="number" 
                            style={{ width: '8%', padding: '.5em', height: 'fit-content' }}
                        />
                        <input 
                            placeholder="Sets" 
                            type="number" 
                            style={{ width: '8%', padding: '.5em', height: 'fit-content' }}
                        />
                        <input 
                            placeholder="Reps" 
                            type="number" 
                            style={{ width: '10%', padding: '.5em', height: 'fit-content' }}
                        />
                        <button>Notes Icon</button>
                    </div>
                    <div style={{ display: 'flex', flexDirection: 'column' }}>
                        <Button style={{ margin: 'auto' }}>
                            Add Exercise
                        </Button>
                        <Button style={{ margin: 'auto' }}>
                            Make Rest Day
                        </Button>
                    </div>
                </div>
            }
        </Modal>
    )
}

export default NewProgramModal