import { Container } from "@mantine/core"
import ChatButton from "../../../components/ChatButton/ChatButton"


const AdminDashboard: React.FC = () => {
    return (
        <div>
            <Container style={{ backgroundColor: 'grey' }}>
                Activity Feed
                
            </Container>
            <ChatButton rootPath="/coach" />
        </div>
    )
}

export default AdminDashboard