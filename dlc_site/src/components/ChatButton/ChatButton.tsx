import { Link } from "react-router-dom"
import { Button } from "@mantine/core"
import { BsChat } from 'react-icons/bs'

const ChatButton: React.FC<{rootPath: string}> = ({ rootPath }) => {
    return (
        <Button 
            style={{ position: 'absolute', bottom: 20, right: 20 }} 
            radius="xl" 
            variant="outline"
            component={Link}
            to={`${rootPath}/chat`}
        >
            <BsChat style={{ fontSize: '2em' }} />
        </Button>
    )
}

export default ChatButton